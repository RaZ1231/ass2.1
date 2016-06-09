package levels;

import utils.Parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @author Raziel Solomon
 * @since 09-Jun-16.
 */
public enum Spec {
    NAME("level_name") {
        @Override
        void setLevel(Level level, String value) {
            level.setName(value);
        }
    },
    VELOCITIES("ball_velocities") {
        @Override
        void setLevel(Level level, String value) {
            VelocityFactory vF = new VelocityFactory();
            level.setBallVelocities(vF.createVelocities(value));
        }
    },
    BACKGROUND("background") {
        @Override
        void setLevel(Level level, String value) {
            Parser parser = new Parser();
            String path = parser.getString(value, "src/definitions/(.)*");
            level.setBackground(path.substring(0, path.length() - 1));
        }
    },
    PAD_SPEED("paddle_speed") {
        @Override
        void setLevel(Level level, String value) {
            level.setPaddleSpeed(Integer.parseInt(value));
        }
    },
    PAD_WIDTH("paddle_width") {
        @Override
        void setLevel(Level level, String value) {
            level.setPaddleWidth(Integer.parseInt(value));
        }
    },
    BLOCKS("block_definitions") {
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
        @Override
        void setLevel(Level level, String value) {
            level.setBlocksXPos(Double.parseDouble(value));
        }
    },
    BLOCKS_Y("blocks_start_y") {
        @Override
        void setLevel(Level level, String value) {
            level.setBlocksYPos(Double.parseDouble(value));
        }
    },
    ROW("row_height") {
        @Override
        void setLevel(Level level, String value) {
            level.setRowHeight(Integer.parseInt(value));
        }
    },
    BLOCKS_NUM("num_blocks") {
        @Override
        void setLevel(Level level, String value) {
            level.setNumOfBlocks(Integer.parseInt(value));
        }
    };

    private String text;

    Spec(String text) {
        this.text = text;
    }

    public static Spec valueOfText(String category) {
        for (Spec spec : values()) {
            if (category.equals(spec.getText())) {
                return spec;
            }
        }

        throw new IllegalArgumentException("Enum text not found.");
    }

    public String getText() {
        return text;
    }

    abstract void setLevel(Level level, String value);
}
