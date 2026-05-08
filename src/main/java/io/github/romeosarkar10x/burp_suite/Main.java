package io.github.romeosarkar10x.burp_suite;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

public class Main implements BurpExtension {

    @Override
    public void initialize(MontoyaApi api) {
        // Set the extension name shown in Burp's Extensions tab
        api.extension().setName("request-sentinel");

        // Log to the extension's Output tab
        api.logging().logToOutput("========================================");
        api.logging().logToOutput("  Hello World Extension Loaded!");
        api.logging().logToOutput("  Burp Suite version: " + api.burpSuite().version().toString());
        api.logging().logToOutput("========================================");

        // Register an unload handler (cleanup when extension is removed)
        api.extension().registerUnloadingHandler(() -> {
            api.logging().logToOutput("Goodbye! Extension unloaded.");
        });
    }
}
