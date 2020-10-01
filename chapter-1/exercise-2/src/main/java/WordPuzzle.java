import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class WordPuzzle {
    private static final Logger logger = LoggerFactory.getLogger(WordPuzzle.class);

    public static void main(String args[]) {
        Set<String> dict = new HashSet<>();
        dict.add("this");
        dict.add("two");
        dict.add("fat");
        dict.add("that");

        Character[][] charBoard = new Character[4][4];
        int i = 0;
        int j = 0;
        charBoard[i][j++] = 't';
        charBoard[i][j++] = 'h';
        charBoard[i][j++] = 'i';
        charBoard[i][j] = 's';

        i = 1;
        j = 0;
        charBoard[i][j++] = 'w';
        charBoard[i][j++] = 'a';
        charBoard[i][j++] = 't';
        charBoard[i][j] = 's';

        i = 2;
        j = 0;
        charBoard[i][j++] = 'o';
        charBoard[i][j++] = 'a';
        charBoard[i][j++] = 'h';
        charBoard[i][j] = 'g';

        i = 3;
        j = 0;
        charBoard[i][j++] = 'f';
        charBoard[i][j++] = 'g';
        charBoard[i][j++] = 'd';
        charBoard[i][j] = 't';

        WordPuzzle wordPuzzle = new WordPuzzle();

        List<Answer> answers = wordPuzzle.solve(charBoard, dict);
    }

    public List<Answer> solve(Character[][] charBoard, Set<String> dict) {
        int height = charBoard.length;
        int width = charBoard[0].length;
        List<Answer> answers = new ArrayList<>();
        Answer answer;
        String curCombo;
        List<Direction> directions = new ArrayList<>();
        directions.add(new Direction(0, 1));
        directions.add(new Direction(-1, 1));
        directions.add(new Direction(-1, 0));
        directions.add(new Direction(-1, -1));
        directions.add(new Direction(0, -1));
        directions.add(new Direction(1, -1));
        directions.add(new Direction(1, 0));
        directions.add(new Direction(1, 1));

        for (int i=0; i < height; i++) {
            for (int j=0; j < width; j++) {
                for (Direction direction : directions) {
                    curCombo = "";
                    for (int k=0; true; k++) {
                        if (direction.row == 1 && (i + k) >= height) {
                            break;
                        }
                        if (direction.row == -1 && (i - k) < 0) {
                            break;
                        }
                        if (direction.col == 1 && (j + k) >= width) {
                            break;
                        }
                        if (direction.col == -1 && (j - k) < 0) {
                            break;
                        }

                        curCombo += charBoard[i + k*direction.row][j + k*direction.col];

                        if (dict.contains(curCombo)) {
                            answer = new Answer(i, j, direction, curCombo);
                            answers.add(answer);
                            logger.info("Found answer {}", answer);
                        }
                    }
                }
            }
        }

        return answers;
    }

    public static class Answer {
        private int row;
        private int col;
        private Direction direction;
        private String word;

        public Answer(int row, int col, Direction direction, String word) {
            this.row = row;
            this.col = col;
            this.direction = direction;
            this.word = word;
        }

        @Override
        public String toString() {
            return "Answer{" +
                    "row=" + row +
                    ", col=" + col +
                    ", direction=" + direction +
                    ", word='" + word + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Answer answer = (Answer) o;
            return row == answer.row &&
                    col == answer.col &&
                    direction == answer.direction &&
                    word.equals(answer.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col, direction, word);
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public Direction getDirection() {
            return direction;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }
    }

    public static class Direction {
        private int row;
        private int col;

        public Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Direction{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Direction direction = (Direction) o;
            return row == direction.row &&
                    col == direction.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }
}
