package levels;

/**
 * command class. create and attach details to level.
 *
 * @author Elisheva Broyer.
 * @since 05/06/2016.
 */
public class Command {
    private String name;
    private String operation;

    public Command(String s) {
        String[] out = s.split(":");
        this.name = out[0];
        this.operation = out[1];
    }

    public void setLevel(Level level) {
        switch (name) {
            case "level_name":
                level.setName(operation);
                break;
            case "ball_velocities":
                VelocityFactory vF = new VelocityFactory();
                level.setBallVelocities(vF.createVelocities(operation));
                break;
            case "background":
                //????
                break;
            case "paddle_speed":
                level.setPaddleSpeed(Integer.parseInt(operation));
                break;
            case "paddle_width":
                level.setPaddleWidth(Integer.parseInt(operation));
                break;
            case "block_definitions":
                BlockFactory bF = new BlockFactory();
                level.setBlocks(bF.createBlocks(operation));
                break;
            case "blocks_start_x":
                level.setBlocksXPos(Double.parseDouble(operation));
                break;
            case "blocks_start_y":
                level.setBlocksYPos(Double.parseDouble(operation));
                break;
            case "row_height":
                level.setRowHeight(Integer.parseInt(operation));
                break;
            case "num_blocks":
                level.setNumOfBlocks(Integer.parseInt(operation));
                break;
        }
    }
}

