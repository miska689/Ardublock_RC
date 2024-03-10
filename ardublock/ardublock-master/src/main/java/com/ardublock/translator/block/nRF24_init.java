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

public class nRF24_init
extends TranslatorBlock {
    public nRF24_init(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        String string = this.getRequiredTranslatorBlockAtSocket(0).toCode();
        String string2 = this.getRequiredTranslatorBlockAtSocket(1).toCode();
        String string3 = this.getRequiredTranslatorBlockAtSocket(2).toCode();
        this.translator.addHeaderFile("SPI.h");
        this.translator.addHeaderFile("nRF24L01.h");
        this.translator.addHeaderFile("RF24.h");
        this.translator.addDefinitionCommand("RF24 radio(" + string + ", " + string2 + "); \nconst byte address[6] = \"" + string3 + "\";");
        this.translator.addSetupCommand("radio.begin();");
        return this.codePrefix + this.codeSuffix;
    }
}
