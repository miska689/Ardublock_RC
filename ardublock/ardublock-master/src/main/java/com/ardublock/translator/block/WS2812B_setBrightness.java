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

public class WS2812B_setBrightness
extends TranslatorBlock {
    public WS2812B_setBrightness(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        String string = this.getRequiredTranslatorBlockAtSocket(0).toCode();
        return this.codePrefix + "FastLED.setBrightness(" + string + ");" + this.codeSuffix;
    }
}
