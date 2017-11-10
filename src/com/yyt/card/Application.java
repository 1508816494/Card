package com.yyt.card;

import com.yyt.card.model.Card;
import com.yyt.card.model.Player;

import java.util.*;

/**
 * @author yyt
 */
public class Application {

    public static void main(String[] args) {
        Application start = new Application();
        start.competiton();

    }


    /**
     * 遍历牌的花色和点数来创建牌
     * @return
     */
    public List<Card> initCardV2() {
        List<Card> cards = new ArrayList<>(52);
        for (Card.Suit suit : Card.Suit.values()) {
            if (suit == Card.Suit.Null) {
                continue;
            }
            for (Card.Point point : Card.Point.values()) {
                cards.add(new Card(suit,point));
            }
        }
        return cards;
    }

    /**
     * 创建玩家
     *
     * @return
     */
    public Player initPlayer(int index) {
        System.out.println("请输入第" + index + "位玩家的姓名：");
        Scanner input = new Scanner(System.in);
        String name1 = input.next();
        return new Player(index, name1);
    }

    public void competiton() {
        //创建牌
        List<Card> cards = initCardV2();

        System.out.println("酱酱酱酱~~~~~~欢迎来到婷婷钓鱼游戏！");
        System.out.println("请创建双方玩家！");

        //创建玩家
        Player player1 = initPlayer(1);
        Player player2 = initPlayer(2);


        System.out.println("成功创建玩家：" + player1.getName() + "和" + player2.getName());

        //洗牌
        System.out.println("游戏开始，下面开始洗牌。。。");
        List<Card> allCards = washCard(cards);
        ArrayList<Card> tableList = new ArrayList<>();

        //发牌
        System.out.println("洗牌完成！下面开始发牌。。。");
        player1.setCardsv2(allCards.subList(0, 26));
        //此处为了方便，直接给出索引值，也可用size()
        player2.setCardsv2(allCards.subList(26, 52));

        //出牌
        System.out.println("发牌完成！游戏开始，请玩家1先出牌！");

        //比赛
        tableGame(player1, player2, tableList);


    }

    /**
     * 洗牌方法
     */
    public List<Card> washCard(List<Card> interList) {
        Collections.shuffle(interList);
        return interList;
    }

    /**
     * 比赛规则，每次出牌后比较当前桌面上是否有相同点数的牌
     * 若有相同，奖励给玩家，并且重新打印出桌面上奖励之后的余牌
     * 若桌面上最后一张牌为J，则此次出牌的玩家获得桌面上所有的牌
     */
    public void compRule(Player player, List<Card> tableList) {
        if (tableList.get(tableList.size() - 1).getPoint().equals("J")) {
            System.out.println("恭喜" + player.getName() + "!您扔出了大钩子！桌面上的所有牌都将奖励给您！");
            player.getCardQueue().addAll(tableList);
            //   player.getCards().addAll(tableList);
            tableList.clear();
            System.out.println("奖励完成！目前桌面上的牌为空！");
        } else {
            for (int i = 0; i < tableList.size(); i++) {                 //玩家每出一次牌检查一下桌面上是否含有点数相同的牌，如果有，将桌面上这两端中间的牌奖励给玩家1
                String temp = tableList.get(i).getPoint();
                for (int j = i + 1; j < tableList.size(); j++) {
                    if (temp.equals(tableList.get(j).getPoint())) {
                        System.out.println("当前桌面上第" + (i + 1) + "张牌和第" + (j + 1) + "牌点数相同，都为" + tableList.get(i).getPoint() + "!两张牌之间的所有牌奖励给" + player.getName());
                        player.getCardQueue().addAll(tableList.subList(i,j + 1));
                        //  player.getCards().addAll(tableList.subList(i, j + 1));
                        tableList.removeAll(tableList.subList(i, j + 1));
                        if (tableList.isEmpty()) {
                            System.out.println("奖励完成！目前桌面上的牌为空！");
                            return;
                        }
                        System.out.println("奖励完成！目前桌面上的牌为:");
                        printListCards(tableList);
                    }
                }
            }
        }
    }

    /**
     * 出牌方法
     */
    public void giveOutCards(Player player, List<Card> tableList) {
        Card outCard = player.getCardQueue().poll();  //poll 方法会自动移除
        tableList.add(outCard);
        System.out.println(player.getName() + "出牌:" + outCard.getSuit() + outCard.getPoint());

    }

    /**
     * 打印纸牌list中花色和点数
     */
    public void printListCards(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(cards.get(i).getSuit() + cards.get(i).getPoint());
        }
    }

    /**
     * 比赛现场
     */

    public void tableGame(Player player1, Player player2, List<Card> tableList) {
        while (!player1.getCardQueue().isEmpty() && !player2.getCardQueue().isEmpty()) {                 //玩家1和玩家2的牌数都不为空
            giveOutCards(player1, tableList);
            compRule(player1, tableList);
            giveOutCards(player2, tableList);
            compRule(player2, tableList);
        }
        if(player1.getCardQueue().isEmpty()) {
            System.out.println(player1.getName()+ "已经没牌啦！游戏结束！恭喜" + player2.getName() + "获胜！老铁就是强哦···");
        }
        if(player2.getCardQueue().isEmpty()) {
            System.out.println(player2.getName() + "已经没牌啦！游戏结束！恭喜" + player1.getName() + "获胜！老铁就是强哦···");
        }

        //System.out.println("游戏结束！" + player1.getName() + "是否获胜：" + !player1.getCards().isEmpty() + "\t" + player2.getName() + "是否获胜：" + !player2.getCards().isEmpty());          //此处需要判断谁获胜
    }
}
