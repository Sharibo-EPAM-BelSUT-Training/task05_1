package gmail.alexejkrawez.production;

import java.util.*;

public class Conveyor {

    /**
     * LinkedList of details.
     */
    private LinkedList<Detail> detailList;

    /**
     * Get the LinkedList of details.
     *
     * @return LinkedList of details.
     */
    public LinkedList<Detail> getDetailList() {
        return detailList;
    }

    /**
     * Constructor of the conveyor that accepts details for fabrication.
     *
     * @param details the details which to be fabrications.
     */
    public Conveyor(Detail... details) {
        detailList = new LinkedList<>(Arrays.asList(details));
    }

    /**
     * Sort the details in ascending t1.
     */
    public static Comparator<Detail> detail_comparator = new Comparator<Detail>() {
        @Override
        public int compare(Detail detail1, Detail detail2) {
            if (detail1.getT1() < detail2.getT1() & detail1.getT1() <= detail2.getT2()) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    /**
     * Sort by Johnson's algorithm.
     *
     * @return the LinkedList of details that have been processed.
     */
    public LinkedList<Detail> algorithmJohnsons() {
        Collections.sort(detailList, detail_comparator);

        Detail detail;
        Detail detail2;
        LinkedList<Detail> finishedList = new LinkedList<Detail>();
        LinkedList<Detail> finishedList2 = new LinkedList<Detail>();
        ListIterator<Detail> iter = detailList.listIterator();

        while (iter.hasNext()) { // ищем детали с t1 <= t2;
            detail = iter.next();
            if (detail.getT1() <= detail.getT2()) {
                finishedList.add(detail);
                iter.remove();
            }
        }

        finishedList2.addFirst(null); // затычка, чтобы не было ошибки NPE
        int k = 0;
        for (; k < detailList.size();) { // ищем детали из оставшихся с наименьшим t2.
            iter = detailList.listIterator(0);
            detail2 = detailList.get(k);
            while (iter.hasNext()) {
                detail = iter.next();
                if (detail.getT2() < detail2.getT2() & !finishedList2.contains(detail)) {
                    detail2 = detail;
                }
            }

            if (finishedList2.contains(detail2)) {
                k++;
            } else {
                finishedList2.addFirst(detail2);
            }
        }

        finishedList2.removeLast(); // удаляем затычку null, оказавшийся последним.
        finishedList.addAll(finishedList2);
        return finishedList;
    }

    /**
     * Get time of full production on two conveyors.
     *
     * @param finishedList the LinkedList of details that have been processed.
     * @return time of full production.
     */
    public int productionTime(LinkedList<Detail> finishedList) {
        int time = 0;
        int time2 = finishedList.get(0).getT1();

        for (Detail detail : finishedList) {
            time += detail.getT1();
            if (time <= time2) {
                time2 += detail.getT2();
            } else {
                time2 += (time - time2) + detail.getT2();
            }
        }

        return time2;
    }

    /**
     * Overrides toString() method.
     *
     * @return details from detailList.
     */
    @Override
    public String toString() {
        return detailList.toString();
    }
}
