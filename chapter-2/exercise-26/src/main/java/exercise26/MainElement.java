package exercise26;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MainElement {
    private static final Logger logger = LoggerFactory.getLogger(MainElement.class);

    /**
     * 书上方法，时间复杂度应该也是O(N)，就是消耗额外空间
     * @return Object mainElement if exist, null otherwise.
     */
    public Object findMethod1(List<Object> inList) {
        logger.debug("inList {}", inList);

        List<Object> workingList = inList;
        List<Object> tmpList = new ArrayList<>();

        while (workingList.size() > 1) {
            int i=0;

            for (; (i+1) < workingList.size(); i+=2) {
                if (workingList.get(i).equals(workingList.get(i+1))) {
                    tmpList.add(workingList.get(i));
                }
            }

            if (i < workingList.size() && (tmpList.size() % 2) == 0) {
                tmpList.add(workingList.get(i));
            }

            workingList = tmpList;
            tmpList = new ArrayList<>();
        }

        if (workingList.size() == 0) {
            logger.debug("No mainElement");
            return null;
        }

        Object candidate = workingList.get(0);
        int cnt = 0;

        for (int i=0; i < inList.size(); i++) {
            if (inList.get(i).equals(candidate)) {
                cnt++;
            }
        }

        if (cnt > (inList.size()/2)) {
            logger.debug("mainElement {}", candidate);
            return candidate;
        }

        logger.debug("No mainElement");
        return null;
    }

    /**
     * 网上方法，时间复杂度O(N)，并且不消耗额外空间，也比书上方法好理解
     * @return Object mainElement if exist, null otherwise.
     */
    public Object findMethod2(List<Object> inList) {
        logger.debug("inList {}", inList);

        if (inList.isEmpty()) {
            logger.debug("No mainElement");
            return null;
        }

        Object candidate = null;
        int cnt = 0;

        for (int i=0; i < inList.size(); i++) {
            if (candidate == null) {
                candidate = inList.get(i);
                cnt = 1;
            } else {
                if (inList.get(i).equals(candidate)) {
                    cnt++;
                } else {
                    cnt--;

                    if (cnt == 0) {
                        candidate = null;
                    }
                }
            }
        }

        if (candidate == null) {
            logger.debug("No mainElement");
            return null;
        }

        cnt = 0;

        for (int i=0; i < inList.size(); i++) {
            if (inList.get(i).equals(candidate)) {
                cnt++;
            }
        }

        if (cnt > (inList.size()/2)) {
            logger.debug("mainElement {}", candidate);
            return candidate;
        }

        logger.debug("No mainElement");
        return null;
    }
}
