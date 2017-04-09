/*
 * The MIT License
 *
 * Copyright 2016 PoVALE Team.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package es.ucm.povale.entity;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * Base IntegerEntity class. 
 * 
 * This entity represents the Integer type.
 *
 * @author PoVALE Team
 */
public class IntegerEntity implements Entity{
    
    private int n;

    public IntegerEntity(int n) {
        this.n = n;
    }

    public int getValue() {
        return n;
    }
   
    @Override
    public boolean equals(Object obj) {
        IntegerEntity b = (IntegerEntity)obj;
        return (this.n == b.n);
    }

    @Override
    public Class<? extends Entity> getType() {
        return IntegerEntity.class;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.n);
    }

    @Override
    public void toXML(Element contents, Document doc) {
        Text t = doc.createTextNode(this.toString());
        contents.appendChild(t);
    }

    @Override
    public void writeToZip(ZipOutputStream zipFile, String outputFile) throws IOException {
        byte[] data;
        String content = toString();
        ZipEntry zipEntry = new ZipEntry(outputFile+".txt");
        zipFile.putNextEntry(zipEntry);
        data = content.getBytes(Charset.forName("UTF-8"));
        zipFile.write(data, 0, content.length());
        zipFile.closeEntry();
    }
    
}
