package February;

/**
 * 765. 情侣牵手    难度：hard
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。
 * 一次交换可选择任意两人，让他们站起来交换座位。
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 *
 * 示例 1:
 *
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * 示例 2:
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 *
 * 说明:
 * len(row) 是偶数且数值在 [4, 60]范围内。
 * 可以保证row 是序列 0...len(row)-1 的一个全排列。
 */

/**
 * 思路：贪心+异或+原地哈希
 *      1.总体思路：若遍历到的元素的旁边不是其配对的元素，则将该元素与他配对的元素交换。
 *      2.如何得知该元素是否是配对的元素？
 *      用二进制异或，相同为0.不同为1，用该元素与二进制1异或，得到的就是其配对的元素，如二进制2为0010，0010^0001 = 0011为3，二进制3为0011^0001 = 0010为2
 *      3.如何原地哈希？
 *      定义一个位置数组，代表每个人对应的位置
 *
 */
public class Feb65_0214 {
    public static int minSwapsCouples(int[] row) {
        int ans = 0;
        int[] pos = new int[row.length];//定义一个位置数组
        for(int i = 0; i < row.length; i++){
            pos[row[i]] = i;//每个人对应的位置，row[0]的位置就是0，row[1]的位置就是1
        }
        for(int i = 0; i < row.length; i += 2){
            int p = row[i];//遍历到的元素
            int q = p ^ 1;//其真正的情侣
            if(row[i + 1] == q){//若i的下一个元素就是q的话，直接处理下一个
                continue;
            }else{
                int fake = i + 1;//标记i+1这个位置
                int real = pos[q];//pos[q]就是其真正的情侣所在的位置
                pos[row[real]] = fake;//把i+1标记给真正元素的位置
                pos[row[fake]] = real;//把真正元素的位置赋给i+1的位置
                swap(row, fake, real);//交换两个位置的值
                ans++;
            }
        }
        System.out.println(ans);
        return ans;
    }
    public static void swap(int[] row, int x, int y){
        int temp = row[x];
        row[x] = row[y];
        row[y] = temp;
    }

    public static void main(String[] args) {
        minSwapsCouples(new int[]{0, 2, 1, 3});
    }
}
