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

public class keypad_1x4_init
extends TranslatorBlock {
    public keypad_1x4_init(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        String string = this.getRequiredTranslatorBlockAtSocket(0).toCode();
        String string2 = this.getRequiredTranslatorBlockAtSocket(1).toCode();
        String string3 = this.getRequiredTranslatorBlockAtSocket(2).toCode();
        String string4 = this.getRequiredTranslatorBlockAtSocket(3).toCode();
        String string5 = this.getRequiredTranslatorBlockAtSocket(4).toCode();
        this.translator.addHeaderFile("Keypad.h");
        this.translator.addDefinitionCommand("const byte ROWS = 1;\nconst byte COLS = 4;\nchar keys[ROWS][COLS] = { '1','2','3','4'};");
        this.translator.addDefinitionCommand("byte rowPins[ROWS] = {" + string5 + "}; \nbyte colPins[COLS] = {" + string + ", " + string2 + ", " + string3 + ", " + string4 + "};");
        this.translator.addDefinitionCommand("Keypad keypad = Keypad( makeKeymap(keys), rowPins, colPins, ROWS, COLS );");
        return this.codePrefix + this.codeSuffix;
    }
}
