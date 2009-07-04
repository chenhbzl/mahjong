package jp.sourceforge.andjong;

import static jp.sourceforge.andjong.Info.*;

/**
 * UIを実装するクラスです。 とりあえず、コンソールで実装します。 TODO オーバーライドしやすい設計にする。
 * 
 * @author Yuji Urushibara
 * 
 */
public class UI {
	private Info info;

	private Tehai tehai = new Tehai();

	public UI(Info info) {
		this.info = info;
	}

	static public String idToString(int id) {
		int kind = id & (Hai.KIND_SHUU | Hai.KIND_TSUU);
		id &= ~(Hai.KIND_SHUU | Hai.KIND_TSUU);

		switch (kind) {
		case Hai.KIND_WAN:
			switch (id) {
			case 1:
				return "一";
			case 2:
				return "二";
			case 3:
				return "三";
			case 4:
				return "四";
			case 5:
				return "五";
			case 6:
				return "六";
			case 7:
				return "七";
			case 8:
				return "八";
			case 9:
				return "九";
			}
			break;
		case Hai.KIND_PIN:
			switch (id) {
			case 1:
				return "�@";
			case 2:
				return "�A";
			case 3:
				return "�B";
			case 4:
				return "�C";
			case 5:
				return "�D";
			case 6:
				return "�E";
			case 7:
				return "�F";
			case 8:
				return "�G";
			case 9:
				return "�H";
			}
			break;
		case Hai.KIND_SOU:
			switch (id) {
			case 1:
				return "１";
			case 2:
				return "２";
			case 3:
				return "３";
			case 4:
				return "４";
			case 5:
				return "５";
			case 6:
				return "６";
			case 7:
				return "７";
			case 8:
				return "８";
			case 9:
				return "９";
			}
			break;
		case Hai.KIND_FON:
			switch (id) {
			case 1:
				return "東";
			case 2:
				return "南";
			case 3:
				return "西";
			case 4:
				return "北";
			}
			break;
		case Hai.KIND_SANGEN:
			switch (id) {
			case 1:
				return "白";
			case 2:
				return "發";
			case 3:
				return "中";
			}
			break;
		}

		return null;
	}

	public void event(int eventCallPlayerIdx, int eventTargetPlayerIdx,
			int eventId) {
		switch (eventId) {
		case EVENTID_TSUMO:
			System.out.println("[" + eventCallPlayerIdx + "]["
					+ eventTargetPlayerIdx + "]EVENTID_TSUMO");
			info.copyTehai(tehai, 0);
			// 純手牌を表示します。
			for (int i = 0; i < tehai.jyunTehaiLength; i++)
				System.out.print(idToString(tehai.jyunTehai[i].id));
			System.out.println();
			break;
		case EVENTID_SUTEHAI:
			System.out.println("[" + eventCallPlayerIdx + "]["
					+ eventTargetPlayerIdx + "]EVENTID_SUTEHAI");
			break;
		case EVENTID_NAGASHI:
			System.out.println("[" + eventCallPlayerIdx + "]["
					+ eventTargetPlayerIdx + "]EVENTID_NAGASHI");
			break;
		default:
			break;
		}
	}
}
