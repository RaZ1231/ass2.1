package levels;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * Level specification enum.
 *
 * @author Raziel Solomon
 * @since 09-Jun-16.
 */
public enum LevelSpec implements TextEnum {
    NAME("level_name") {
        /**
         * set value to level.
         *
         * @param level level to set
         * @param value value to set
         */
        @Override
        void setLevel(Level level, String value) {
            level.setName(value);
        }
    },
    VELOCITIES("ball_velocities") {
        /**
         * set value to level.
         *
         * @param level level to set
         * @param value value to set
         */
        @Override
        void setLevel(Level level, String value) {
            VelocityFactory vF = new VelocityFactory();
            level.setBallVelocities(vF.createVelocities(value));
        }
    },
    BACKGROUND("background") {
        /**
         * set value to level.
         *
         * @param level level to set
         * @param value value to set
         */
        @Override
        void setLevel(Level level, String value) {
            level.setBackground(FillParser.fromString(
                    value.substring(6, value.length() - 1)));
        }
    },
    PAD_SPEED("paddle_speed") {
        /**
         * set value to level.
         *
         * @param level level to set
         * @param value value to set
         */
        @Override
        void setLevel(Level level, String value) {
            level.setPaddleSpeed(Integer.parseInt(value));
        }
    },
    PAD_WIDTH("paddle_width") {
        /**
         * set value to level.
         *
         * @param level level to set
         * @param value value to set
         */
        @Override
        void setLevel(Level level, String value) {
            level.setPaddleWidth(Integer.parseInt(value));
        }
    },
    BLOCKS("block_definitions") {
        /**
         * set value to level.
         *
         * @param level level to set
         * @param value value to set
         */
        @Override
        void setLevel(Level level, String value) {
            try {
                level.setbFSF(BlocksDefinitionReader.fromReader
                        (new BufferedReader(new InputStreamReader(new FileInputStream(value)))));
            } catch (FileNotFoundException e) {
            }
        }
    },
    BLOCKS_X("blocks_start_x") {
        /**
         * set value to level.
         *
         * @param level level to set
         * @param value value to set
         */
        @Override
        void setLevel(Level level, String value) {
            level.setBlocksXPos(Double.parseDouble(value));
        }
    },
    BLOCKS_Y("blocks_start_y") {
        /**
         * set value to level.
         *
         * @param level level to set
         * @param value value to set
         */
        @Override
        void setLevel(Level level, String value) {
            level.setBlocksYPos(Double.parseDouble(value));
        }
    },
    ROW("row_height") {
        /**
         * set value to level.
         *
         * @param level level to set
         * @param value value to set
         */
        @Override
        void setLevel(Level level, String value) {
            level.setRowHeight(Integer.parseInt(value));
        }
    },
    BLOCKS_NUM("num_blocks") {
        /**
         * set value to level.
         *
         * @param level level to set
         * @param value value to set
         */
        @Override
        void setLevel(Level level, String value) {
            level.setNumOfBlocks(Integer.parseInt(value));
        }
    };

    private String text;

    /**
     * constructor.
     *
     * @param text specification
     */
    LevelSpec(String text) {
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
     * set value to level.
     *
     * @param level level to set
     * @param value value to set
     */
    abstract void setLevel(Level level, String value);
}
