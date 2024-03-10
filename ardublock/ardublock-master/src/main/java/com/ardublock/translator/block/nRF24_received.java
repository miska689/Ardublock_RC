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

public class nRF24_received
extends TranslatorBlock {
    public nRF24_received(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        String string = this.getRequiredTranslatorBlockAtSocket(0).toCode();
        this.translator.addSetupCommand("radio.openReadingPipe(0, address);\nradio.setPALevel(RF24_PA_MIN);\nradio.startListening();");
        String string2 = "if(radio.available()){\nradio.read(&" + string + ", sizeof(" + string + "));\n}";
        return this.codePrefix + string2 + this.codeSuffix;
    }
}
