package com.chenss.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 36. 有效的数独
 * <p>
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenss002
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] hBl = new boolean[9][9];
        boolean[][] lBl = new boolean[9][9];
        boolean[][] hlBl = new boolean[9][9];
        // 横向和纵向判断
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    int hl = (i / 3) * 3 + j / 3;
                    int c = board[i][j] - '1';
                    if (hBl[i][c] || lBl[j][c] || hlBl[hl][c]) {
                        return false;
                    }
                    hBl[i][c] = true;
                    lBl[j][c] = true;
                    hlBl[hl][c] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = new char[9][9];

        /*board[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};*/
        board[0] = new char[]{'.','.','.','.','.','.','5','.','.'};
        board[1] = new char[]{'.','.','.','.','.','.','.','.','.'};
        board[2] = new char[]{'.','.','.','.','.','.','.','.','.'};
        board[3] = new char[]{'9','3','.','.','2','.','4','.','.'};
        board[4] = new char[]{'.','.','7','.','.','.','3','.','.'};
        board[5] = new char[]{'.','.','.','.','.','.','.','.','.'};
        board[6] = new char[]{'.','.','.','3','4','.','.','.','.'};
        board[7] = new char[]{'.','.','.','.','.','3','.','.','.'};
        board[8] = new char[]{'.','.','.','.','.','5','2','.','.'};
        System.out.println(validSudoku.isValidSudoku(board));
    }
}
