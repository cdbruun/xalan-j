/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2002-2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:  
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Xalan" and "Apache Software Foundation" must
 *    not be used to endorse or promote products derived from this
 *    software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    nor may "Apache" appear in their name, without prior written
 *    permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation and was
 * originally based on software copyright (c) 1999, Lotus
 * Development Corporation., http://www.lotus.com.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
package org.apache.xpath.rwapi.expression;

import org.apache.xpath.rwapi.XPathException;

/**
 * Represents for and quantified expressions.
 * <pre>
 * [6]   ForExpr   ::=   (ForClause "return")* QuantifiedExpr 
 * [21]  ForClause   ::=   <"for" "$"> VarName "in" Expr ("," "$" VarName "in" Expr)*
 * [7]   QuantifiedExpr   ::=   ((<"some" "$"> |  <"every" "$">) VarName "in" Expr ("," "$" VarName "in" Expr)* "satisfies")* IfExpr
 * </pre>
 * @see <a href="http://www.w3.org/TR/xpath20/#id-quantified-expressions">XPath 2.0 Specification</a>
 * @see <a href="http://www.w3.org/TR/xpath20/#id-flwr-expressions">XPath 2.0 Specification</a>
 */
public interface ForAndQuantifiedExpr extends Expr {
    
    /**
     * 
     * @return String
     */
    String getClauseVarName( int i );
    
    /**
     * 
     */
    Expr getClauseExpr( int i );
    
    /**
     * 
     */
    int getClauseCount();
    
    /**
     * @throws XPathException when expression type isn't a 'for' one.
     */
    Expr getReturnExpr() throws XPathException;
    
    /**
     * @throws XPathException when expression type isn't a quantified one.
     */
    Expr getSatisfyExpr() throws XPathException;
    
    /**
     * 
     */
    void addClause( String varName, Expr expr );
    
    /**
     * 
     */
    void removeClause( String varName );
    
}
