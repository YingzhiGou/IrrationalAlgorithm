package im.irrational.algorithm.GameTreeSearch;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;

/**
 * Created by Simon M. Lucas
 * sml@essex.ac.uk
 * Date: 29-Nov-2010
 * Time: 22:23:45
 * <p>
 * modified by Yingzhi
 * <p/>
 * Simple TreeView for a Tree
 */
public class TreeViewer extends JComponent {
    public static final Color fg = Color.black;
    public static final Color bg = Color.cyan;
    public static final Color selectedColor = Color.blue;
    public static final Color nodeBg = Color.white;
    public static final Color highlighted = Color.red;
    public static final Color terninalNode = Color.yellow;
    TreeNode root;
    int nw = 80;
    int nh = 16;
    int inset = 20;
    int minWidth = 1024;
    int heightPerLevel = 40;
    // the highlighted set of nodes...
    HashSet<TreeNode> selectedNodes;
    private JEasyFrame frame;

    public TreeViewer(TreeNode root) {
        setTree(root);
        setSelectedNodes(new HashSet<TreeNode>());
    }

    public TreeViewer() {
        this.root = null;
    }

    public void paintComponent(Graphics gg) {
        // Font font =
        // g.setFont();
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int y = inset;
        int x = getWidth() / 2;
        //g.setColor(bg);
        //g.fillRect(0, 0, getWidth(), getHeight());
        draw(g, root, x, y, (int) (1.1 * getWidth()) - inset * 0);
    }

    public void setTree(TreeNode root) {
        this.root = root;
        this.selectedNodes = null;
        this.addSelected(root);
    }

    public void setSelectedNodes(HashSet<TreeNode> selectedNodes) {
        this.selectedNodes = selectedNodes;
    }

    private void draw(Graphics2D g, TreeNode cur, int x, int y, int wFac) {
        if (cur == null) {
            return;
        }
        // draw this one, then it's children
        int index = 0, arity = cur.arity();
        for (Object child :
                cur.getChildren()) {
            TreeNode childNode = (TreeNode) child;
            int xx = (int) ((index + 1.0) * wFac / (arity + 1) + (x - wFac / 2));
            int yy = y + heightPerLevel;
            if (selectedNodes != null && selectedNodes.contains(cur)) {
                g.setColor(selectedColor);
            } else {
                g.setColor(fg);
            }
            g.drawLine(x, y, xx, yy);
            g.drawString(childNode.getAction().toString(), x + (x - xx) / 2, y + heightPerLevel / 2 - 2);
            draw(g, childNode, xx, yy, wFac / arity);
        }
        drawNode(g, cur, x, y);
    }

    private void drawNode(Graphics2D g, TreeNode node, int x, int y) {
        if (node.isTerminal()) {
            g.setColor(terninalNode);
        } else {
            g.setColor(nodeBg);
        }
        g.fillRect(x - nw / 2, y - nh / 2, nw, nh);
        if (selectedNodes != null && selectedNodes.contains(node)) {
            g.setColor(selectedColor);
        } else {
            g.setColor(fg);
        }
        g.drawRect(x - nw / 2, y - nh / 2, nw, nh);
        if (selectedNodes != null && selectedNodes.contains(node)) {
            g.setColor(selectedColor);
        } else {
            g.setColor(fg);
        }
        FontMetrics fm = g.getFontMetrics();
        String s = node.toString();
        Rectangle2D rect = fm.getStringBounds(s, g);
        g.drawString(s, x - (int) (rect.getWidth() / 2), (int) (y + rect.getHeight() / 2 - 2));
    }

    public Dimension getPreferredSize() {
        // should make this depend on the tree ...
        return new Dimension(minWidth, heightPerLevel * (10 - 1) + inset * 2);
    }

    public JEasyFrame showTree(String title) {
        frame = new JEasyFrame(this, title);
        return frame;
    }

    public void setFrameTitle(String title) {
        if (frame == null) {
            showTree(title);
        } else {
            frame.setTitle(title);
        }
    }

    public void addSelected(TreeNode node) {
        if (selectedNodes == null) {
            selectedNodes = new HashSet<>();
        }
        selectedNodes.add(node);
    }
}

class JEasyFrame extends JFrame {
    private Component comp;

    JEasyFrame(Component comp, String title) {
        super(title);
        this.comp = comp;
        getContentPane().add(BorderLayout.CENTER, comp);
        pack();
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();
    }
}

