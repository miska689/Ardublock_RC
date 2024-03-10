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

public class LED_matrix_init
extends TranslatorBlock {
    public LED_matrix_init(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
        String string = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
        String string2 = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
        String string3 = translatorBlock.toCode();
        this.translator.addHeaderFile("LedControl.h");
        this.translator.addDefinitionCommand("LedControl matrix(" + string + ", " + string3 + ", " + string2 + ", 0);");
        this.translator.addSetupCommand("matrix.shutdown(0, false);\n matrix.setIntensity(0, 15);\n matrix.clearDisplay(0);");
        return this.codePrefix + this.codeSuffix;
    }
}
