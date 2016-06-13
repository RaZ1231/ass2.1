package levels;

import blocks.Block;
import interfaces.Fill;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import sprites.FillColor;

/**
 * Class to contain block info.
 *
 * @author Raziel Solomon
 * @since 09-Jun-16.
 */
public class ContainerBlock {
    private String symbol;
    private double width;
    private double height;
    private int hits;
    private Fill fill;
    private Color stroke;
    private Map<Integer, Fill> fillK;

    /**
     * constructor.
     */
    public ContainerBlock() {
        fill = new FillColor(Color.white);
        fillK = new HashMap<>();
    }

    /**
     * constructor.
     *
     * @param symbol symbol character
     * @param width  block width
     * @param height block height
     * @param hits   block hit counter
     * @param fill   block filling
     * @param stroke block strock color
     * @param fillK  block fill-k map
     */
    public ContainerBlock(String symbol, double width, double height, int hits, Fill fill, Color stroke,
                          Map<Integer, Fill> fillK) {
        this.symbol = symbol;
        this.width = width;
        this.height = height;
        this.hits = hits;
        this.fill = fill;
        this.stroke = stroke;
        this.fillK = copy(fillK);
    }

    /**
     * copy fill-k map.
     *
     * @param map map to copy
     * @return new map
     */
    private static Map<Integer, Fill> copy(Map<Integer, Fill> map) {
        Map<Integer, Fill> newMap = new HashMap<>();

        for (Map.Entry<Integer, Fill> entry : map.entrySet()) {
            newMap.put(entry.getKey(), entry.getValue());
        }

        return newMap;
    }

    /**
     * create container from existing block.
     *
     * @param block block to create by
     * @return new container
     */
    public static ContainerBlock fromBlock(Block block) {
        return new ContainerBlock("", block.getRect().getWidth(), block.getRect().getHeight(), block.getHitPoints(),
                block.getFill(), block.getStroke(), copy(block.getFillK()));
    }

    /**
     * String representation.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "ContainerBlock{"
                + "symbol='" + symbol + '\''
                + ", width=" + width
                + ", height=" + height
                + ", hits=" + hits
                + ", fill=" + fill
                + ", stroke=" + stroke + '}';
    }

    /**
     * Gets symbol.
     *
     * @return Value of symbol.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets new symbol.
     *
     * @param aSymbol New value of symbol.
     */
    public void setSymbol(String aSymbol) {
        this.symbol = aSymbol;
    }

    /**
     * Gets hits.
     *
     * @return Value of hits.
     */
    public int getHits() {
        return hits;
    }

    /**
     * Sets new hits.
     *
     * @param hitsNum New value of hits.
     */
    public void setHits(int hitsNum) {
        this.hits = Math.abs(hitsNum);
    }

    /**
     * Gets stroke.
     *
     * @return Value of stroke.
     */
    public Color getStroke() {
        return stroke;
    }

    /**
     * Sets new stroke.
     *
     * @param cStroke New value of stroke.
     */
    public void setStroke(Color cStroke) {
        this.stroke = cStroke;
    }

    /**
     * Gets width.
     *
     * @return Value of width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets new width.
     *
     * @param widthSize New value of width.
     */
    public void setWidth(double widthSize) {
        this.width = Math.abs(widthSize);
    }

    /**
     * Gets fillK.
     *
     * @return Value of fillK.
     */
    public Map<Integer, Fill> getFillK() {
        return fillK;
    }

    /**
     * Sets new fillK.
     *
     * @param fillOfK New value of fillK.
     */
    public void setFillK(Map<Integer, Fill> fillOfK) {
        this.fillK = fillOfK;
    }

    /**
     * Gets height.
     *
     * @return Value of height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets new height.
     *
     * @param heightSize New value of height.
     */
    public void setHeight(double heightSize) {
        this.height = Math.abs(heightSize);
    }

    /**
     * Gets fill.
     *
     * @return Value of fill.
     */
    public Fill getFill() {
        return fill;
    }

    /**
     * Sets new fill.
     *
     * @param aFill New value of fill.
     */
    public void setFill(Fill aFill) {
        this.fill = aFill;
    }

    /**
     * put fill-k in map.
     *
     * @param k     hits
     * @param aFill filling
     */
    public void putFillK(int k, Fill aFill) {
        fillK.put(k, aFill);
    }
}
