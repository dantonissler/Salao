package main.java.tools;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class StringDocumentUpperCase extends PlainDocument{
	
	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 * https://www.youtube.com/watch?v=0kpCsqqQuqs
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException{
		super.insertString(offset, str.toUpperCase().replaceAll("[^a-z|^A-Z]", ""), attr);
	}
	public void replace(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException{
		super.insertString(offset, str.replaceAll("[^a-z|^A-Z]", ""), attr);
	}
}