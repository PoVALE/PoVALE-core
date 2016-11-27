/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg.reader;

import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import tfg.entity.IntegerEntity;
import tfg.entity.StringEntity;
import tfg.term.FunctionApplication;
import tfg.term.ListTerm;
import tfg.term.LiteralInteger;
import tfg.term.LiteralString;
import tfg.term.Term;
import tfg.term.Variable;

/**
 *
 * @author Laura Hernando y Daniel Rossetto
 */



public class TermParser {
    
    public Term createVariable(Element el){
        return new Variable(el.getTextContent());
    }
    
    public Term createLiteralString(Element el){
        StringEntity s = new StringEntity(el.getTextContent());
        return new LiteralString(s);
    }
    
    public Term createLiteralInteger(Element el){
        int integer = Integer.parseInt(el.getTextContent());
        IntegerEntity ie = new IntegerEntity(integer);
        return new LiteralInteger(ie);
    }
    
    public Term createListTerm(Element el){
        XMLParser parser = new XMLParser();
        List<Term> terms = new LinkedList();
        NodeList nl = el.getChildNodes();
        if(nl != null && nl.getLength() > 0) 
            for(int i = 0 ; i < nl.getLength(); i++) 
                if(!nl.item(i).getNodeName().equalsIgnoreCase("#text")){
                    Element e = (Element)nl.item(i);
                    terms.add(parser.getTerm(e));
                }
        return new ListTerm(terms);
    }
    
    public Term createFunctionApplication(Element el){
        XMLParser parser = new XMLParser();
        String function = null;
        List<Term> terms = new LinkedList();
        NodeList nodeList = el.getChildNodes();
        if(nodeList != null && nodeList.getLength()>0)
            for(int i = 0; i < nodeList.getLength(); i++)
                if(!nodeList.item(i).getNodeName().equalsIgnoreCase("#text"))
                    if(function == null)
                        function = nodeList.item(i).getTextContent();
                    else{
                        NodeList termList = nodeList.item(i).getChildNodes();
                        if(termList != null && termList.getLength()>0)
                            for(int j = 0; j < termList.getLength(); j++)
                                if(!termList.item(j).getNodeName().equalsIgnoreCase("#text"))
                                    terms.add(parser.getTerm((Element)termList.item(j)));
                    }
        return new FunctionApplication(function, terms);
    }
}
