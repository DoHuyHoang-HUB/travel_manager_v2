package com.huyhoang.swing.button;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Button extends JButton {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Animator animator;
    private int targetSize;
    private float animatSize;
    private Point pressedPoint;
    private float alpha;
    private Color effectColor = new Color(173, 173, 173);
    private boolean borderline = false;
    private int borderRadius = 0;
    private Color borderColor = new Color(0, 0, 0, 0.3f);

    public Color getEffectColor() {
        return effectColor;
    }

    public void setEffectColor(Color effectColor) {
        this.effectColor = effectColor;
    }

    public boolean isBorderline() {
        return borderline;
    }

    public void setBorderline(boolean borderline) {
        this.borderline = borderline;
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }
    
    public Button() {
        buidButton();
    }

    public Button(String text) {
        super(text);
        buidButton();
    }

    public Button(String text, boolean fillRoundRect) {
        super(text);
        setBorderline(fillRoundRect);
        buidButton();
    }

    private void buidButton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBackground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                targetSize = Math.max(getWidth(), getHeight()) * 2;
                animatSize = 0;
                pressedPoint = e.getPoint();
                alpha = 0.5f;
                if (animator.isRunning()) {
                    animator.stop();
                }
                animator.start();
            }
        });
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (fraction > 0.5f) {
                    alpha = 1 - fraction;
                }
                animatSize = fraction * targetSize;
                repaint();
            }
        };
        animator = new Animator(400, target);
        animator.setResolution(0);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        if (borderline == true) {
            if(borderRadius > 0) {
                g2.fillRoundRect(0, 0, width, height, borderRadius, borderRadius);
                g2.setColor(borderColor);
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, borderRadius, borderRadius);
            }
            else {
                g2.fillRoundRect(0, 0, width, height, height, height);
            }
        } else {
            g2.fillRoundRect(0, 0, width, height, borderRadius, borderRadius);
        }
        if (pressedPoint != null) {
            g2.setColor(effectColor);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            g2.fillOval((int) (pressedPoint.x - animatSize / 2), (int) (pressedPoint.y - animatSize / 2), (int) animatSize, (int) animatSize);
        }
        g2.dispose();
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }

}
