package com.huyhoang.swing.button;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ButtonInfo extends JButton {

    private boolean hover;
    private boolean selected;
    private Icon prefixIcon;
    private Icon suffixIcon;
    private boolean borderLine = false;
    private Color borderColor = new Color(0, 0, 0, 0.3f);
    private int borderRadius = 0;
    private String textName = "";
    private String textRoll = "";

    public Icon getPrefixIcon() {
        return prefixIcon;
    }

    public void setPrefixIcon(Icon prefixIcon) {
        this.prefixIcon = prefixIcon;
    }

    public Icon getSuffixIcon() {
        return suffixIcon;
    }

    public void setSuffixIcon(Icon suffixIcon) {
        this.suffixIcon = suffixIcon;
    }

    public boolean isBorderLine() {
        return borderLine;
    }

    public void setBorderLine(boolean borderLine) {
        this.borderLine = borderLine;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getTextRoll() {
        return textRoll;
    }

    public void setTextRoll(String textRoll) {
        this.textRoll = textRoll;
    }

    public ButtonInfo() {
        setOpaque(false);
        setContentAreaFilled(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (selected || hover) {
            if (selected) {
                g2.setColor(new Color(0, 0, 0, 0.3f));
            } else {
                g2.setColor(new Color(0, 0, 0, 0.1f));
            }
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);
        }
        paintIcon(grphcs);
        super.paintComponent(grphcs);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height);
        int x = width / 2 - diameter / 2;
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        FontMetrics fm = g.getFontMetrics();
        g.setColor(getForeground());
        g.drawString(textName, x, height / 2 + fm.getAscent() / 2 - 10);
        g.setColor(new Color(127, 127, 127));
        g.drawString(textRoll, x, height / 2 + fm.getAscent());
    }

    private void paintIcon(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height);

        Rectangle size = getAutoSize(prefixIcon, diameter);
        BufferedImage img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2_img = img.createGraphics();
        g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (prefixIcon != null) {
            int y = height / 2 - diameter / 2;
            g2_img.fillOval(0, 0, diameter, diameter);
            Composite composite = g2_img.getComposite();
            g2_img.setComposite(AlphaComposite.SrcIn);
            g2_img.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2_img.drawImage(toImage(prefixIcon), size.x, size.y, size.width, size.height, null);
            g2_img.setComposite(composite);
            g2_img.dispose();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (isOpaque()) {
                g2.setColor(getBackground());
                g2.fillOval(5, y, diameter, diameter);
            }
            g2.drawImage(img, 5, 0, this);
        }

        if (suffixIcon != null) {
            Image suffix = toImage(suffixIcon);
            int y = (getHeight() - suffixIcon.getIconHeight()) / 2;
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(suffix, getWidth() - suffixIcon.getIconWidth() - 5, y, this);
        }
    }

    private Rectangle getAutoSize(Icon image, int size) {
        int w = size;
        int h = size;
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        int cw = size;
        int ch = size;
        int x = (cw - width) / 2;
        int y = (ch - height) / 2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }
}
