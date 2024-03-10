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

public class keypad_1x4_checkPassword
extends TranslatorBlock {
    public keypad_1x4_checkPassword(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        TranslatorBlock translatorBlock;
        String string = this.getRequiredTranslatorBlockAtSocket(0).toCode();
        String string2 = this.getRequiredTranslatorBlockAtSocket(1).toCode();
        int n = string.length() - 1;
        this.translator.addDefinitionCommand("#define Password_Length " + n + "");
        this.translator.addDefinitionCommand("char Data[Password_Length];");
        this.translator.addDefinitionCommand("char Master[Password_Length] = " + string + ";");
        this.translator.addDefinitionCommand("byte data_count = 0, master_count = 0;");
        this.translator.addDefinitionCommand("\nvoid clearData(){\nwhile(data_count !=0){\nData[data_count--] = 0;\n}\nreturn;\n}");
        String string3 = "if(" + string2 + "){\nData[data_count] = " + string2 + ";\ndata_count++;\n}";
        string3 = string3 + "if(data_count == Password_Length-1){";
        string3 = string3 + "if(!strcmp(Data, Master)){";
        for (translatorBlock = this.getTranslatorBlockAtSocket(2); translatorBlock != null; translatorBlock = translatorBlock.nextTranslatorBlock()) {
            string3 = string3 + translatorBlock.toCode();
        }
        string3 = string3 + "}\nelse{\n";
        for (translatorBlock = this.getTranslatorBlockAtSocket(3); translatorBlock != null; translatorBlock = translatorBlock.nextTranslatorBlock()) {
            string3 = string3 + translatorBlock.toCode();
        }
        string3 = string3 + "}\nclearData();\n}\n";
        return string3;
    }
}
