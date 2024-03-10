/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.ardublock.translator.Translator
 *  com.ardublock.translator.block.TranslatorBlock
 *  com.ardublock.translator.block.exception.SocketNullException
 *  com.ardublock.translator.block.exception.SubroutineNotDeclaredException
 */
package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class WS2812B_init
extends TranslatorBlock {
    public WS2812B_init(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        String string = this.getRequiredTranslatorBlockAtSocket(0).toCode();
        String string2 = this.getRequiredTranslatorBlockAtSocket(1).toCode();
        this.translator.addHeaderFile("FastLED.h");
        this.translator.addDefinitionCommand("#define NUM_LEDS\t" + string2 + " \n#define DATA_PIN\t" + string + "\n CRGB leds[NUM_LEDS];");
        this.translator.addSetupCommand("FastLED.addLeds<WS2812B, DATA_PIN, GRB>(leds, NUM_LEDS);");
        return this.codePrefix + this.codeSuffix;
    }
}
