(ns collatz-conjecture)

(defn collatz [num & {:keys [accum] :or {accum 0}}]
  (cond
    (<= num 0) (throw (IllegalArgumentException.))
    (= num 1) accum
    :else (if (odd? num)
            (recur (inc (* num 3)) {:accum (inc accum)})
            (recur (/ num 2) {:accum (inc accum)}))))