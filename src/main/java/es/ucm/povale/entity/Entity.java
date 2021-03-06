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
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Base Entity class. 
 * 
 * An entity is something which could meet requirements. In the core there are
 * implement three basic types of entities, integer, string and list of
 * entities. it could add more types of entities which are implemented in
 * plugins.
 *
 * 
 * @author PoVALE Team
 */
public interface Entity {
    
    default Class<? extends Entity> getType(){
        return this.getClass();
    }
    
    public abstract void toXML(Element contents, Document doc);
    
    public abstract void writeToZip(ZipOutputStream z, String outputFile) throws IOException;
    
    
    //public abstract Class<? extends Entity> fromXML(Element contents, Document doc);
    //public static Class<? extends Entity> fromZip(ZipFile file);

}
