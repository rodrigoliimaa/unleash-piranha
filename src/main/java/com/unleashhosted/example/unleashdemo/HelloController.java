package com.unleashhosted.example.unleashdemo;

import javax.servlet.http.HttpSession;

import no.finn.unleash.Unleash;
import no.finn.unleash.UnleashContext;
import no.finn.unleash.Variant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Unleash unleash;

    @RequestMapping("/")
    public String index(HttpSession session) {
        UnleashContext context = UnleashContext.builder()
                .sessionId(session.getId())
                .build();
        
        if(unleash.isEnabled("Demo", context)) {
            return "Cloroquina ta ativada";
        } else {
            return "Cloroquina ta desativada.";
        }
    }

    @RequestMapping("/variants")
    public String variants(HttpSession session) {
        UnleashContext context = UnleashContext.builder()
                .sessionId(session.getId())
                .build();

        String variantName = unleash.getVariant("CloroquinaVariant", context).getName();

        switch (variantName) {
            case "red": return "1000mg";
            case "green": return "200mg";
            case "blue": return "400mg";
            default: return "Você não tomou ainda";
        }
    }
}