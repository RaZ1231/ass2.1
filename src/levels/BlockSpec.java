package levels;

import sprites.FillColor;
import utils.Parser;

/**
 * Block specification enum.
 *
 * @author Raziel Solomon
 * @since 09-Jun-16.
 */
public enum BlockSpec implements TextEnum {
    SYMBOL("symbol") {
        /**
         * set block specification to value.
         *
         * @param block block to set
         * @param value value to set
         */
        @Override
        void setBlock(ContainerBlock block, String value) {
            block.setSymbol(value);
        }
    },
    WIDTH("width") {
        /**
         * set block specification to value.
         *
         * @param block block to set
         * @param value value to set
         */
        @Override
        void setBlock(ContainerBlock block, String value) {
            block.setWidth(Double.parseDouble(value));
        }
    },
    HEIGHT("height") {
        /**
         * set block specification to value.
         *
         * @param block block to set
         * @param value value to set
         */
        @Override
        void setBlock(ContainerBlock block, String value) {
            block.setHeight(Double.parseDouble(value));
        }
    },
    FILL("fill") {
        /**
         * set block specification to value.
         *
         * @param block block to set
         * @param value value to set
         */
        @Override
        void setBlock(ContainerBlock block, String value) {
            block.setFill(FillParser.fromString(
                    value.substring(6, value.length() - 1)));
        }
    },
    STROKE("stroke") {
        /**
         * set block specification to value.
         *
         * @param block block to set
         * @param value value to set
         */
        @Override
        void setBlock(ContainerBlock block, String value) {
            block.setStroke(((FillColor) FillParser.fromString(
                    value.substring(6, value.length() - 1))).getColor());
        }
    },
    HITS("hit_points") {
        /**
         * set block specification to value.
         *
         * @param block block to set
         * @param value value to set
         */
        @Override
        void setBlock(ContainerBlock block, String value) {
            block.setHits(Integer.parseInt(value));
        }
    };

    private String text;

    /**
     * constructor.
     *
     * @param text specification
     */
    BlockSpec(String text) {
        this.text = text;
    }

    /**
     * text getter.
     *
     * @return specification
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * get specification value.
     *
     * @return value
     */
    public String getValue() {
        Parser parser = new Parser();

        return parser.getString(text, ".*?\\((.*)\\)", 1);
    }

    /**
     * set block specification to value.
     *
     * @param block block to set
     * @param value value to set
     */
    abstract void setBlock(ContainerBlock block, String value);
}
