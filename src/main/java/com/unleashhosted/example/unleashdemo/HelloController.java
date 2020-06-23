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

        boolean isEnabled = unleash.isEnabled("Demo", context);
        if(unleash.isEnabled("Demo")) {
            return "Greeting, Demo flag is enabled";
        } else {
            return "Doh, Demo was disabled.";
        }
    }


    @RequestMapping("/variants")
    public String variants(HttpSession session) {
        UnleashContext context = UnleashContext.builder()
                .sessionId(session.getId())
                .build();

        Variant variant = unleash.getVariant("VariantExample", context);
        return "variant selected: " + variant.getName();
    }
}
