package logica;

import java.awt.Component;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class RenderCelda extends DefaultTableCellRenderer 
{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) 
    {
        JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if( value instanceof Integer)
        {
            int amount = (int) value;
            cell.setBackground(Color.GREEN);
            cell.setForeground(Color.BLACK);
        }else{
	        	String Valor = (String) value;
	        	cell.setBackground(Color.WHITE);
	            cell.setForeground(Color.BLACK);
        }
        
        return cell;
    }
}