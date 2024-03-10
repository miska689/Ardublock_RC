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

public class Rfid_rc522_read_UID
extends TranslatorBlock {
    public Rfid_rc522_read_UID(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        this.translator.addDefinitionCommand("\n String return_UID(){\n String content= \" \";\n for(byte i=0; i<mfrc522.uid.size; i++){\n content.concat(String(mfrc522.uid.uidByte[i] < 0x10 ? \"0\" : \"\"));\n content.concat(String(mfrc522.uid.uidByte[i], HEX));\n }\ncontent.toUpperCase();\n return content.substring(1);\n }\n ");
        this.translator.addSetupCommand("Serial.println(\"Approximate your card to the reader...\"); \n Serial.println();");
        return this.codePrefix + "return_UID()" + this.codeSuffix;
    }
}
