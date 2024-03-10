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

public class Rfid_rc522_init
extends TranslatorBlock {
    public Rfid_rc522_init(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
        String string = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
        String string2 = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
        String string3 = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(3);
        String string4 = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(4);
        String string5 = translatorBlock.toCode();
        this.translator.addHeaderFile("SPI.h");
        this.translator.addHeaderFile("MFRC522.h");
        this.translator.addDefinitionCommand("MFRC522 mfrc522(" + string4 + ", " + string5 + ");");
        this.translator.addSetupCommand("SPI.begin(); \n mfrc522.PCD_Init();");
        return this.codePrefix + "if(!mfrc522.PICC_IsNewCardPresent()) return; \nif(!mfrc522.PICC_ReadCardSerial()) return;\n" + this.codeSuffix;
    }
}
