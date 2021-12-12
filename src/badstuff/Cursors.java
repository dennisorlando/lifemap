package badstuff;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import main.Main;

public class Cursors {
	public static Cursor default_cursor = new Cursor(Cursor.DEFAULT_CURSOR);
	public static Cursor cross = new Cursor(Cursor.CROSSHAIR_CURSOR);
	public static Cursor delete = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(Main.class.getResource("/assets/cursor_delete.png")).getImage(), new Point(0,0), "delete_cursor");
	public static Cursor hand = new Cursor(Cursor.HAND_CURSOR);
	public static Cursor blank = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "blank cursor");
}
