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
package es.ucm.povale.plugin;

import es.ucm.povale.entity.Entity;
import java.util.List;

import es.ucm.povale.function.Function;
import es.ucm.povale.predicate.Predicate;
import es.ucm.povale.parameter.ParameterEditor;
import java.util.Map;

public abstract class PluginInfo {
    
    
    public abstract String getIdPlugin();
    
    public abstract List<Function> getFunctions();
    
    public  abstract List<Predicate> getPredicates();
   
    public abstract  List<Class<?>> getEntities();
    
    public abstract List<String> getEditorTypes();
    
    public abstract ParameterEditor<? extends Entity> getEditor(String name, Map<String,String> parameters);
    
}
