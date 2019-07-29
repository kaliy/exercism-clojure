(ns armstrong-numbers)

(defn num-to-digits [num & {:keys [accum] :or {accum `()}}]
  (let [current-num (biginteger (mod num 10))]
    (if (> num 0)
      (num-to-digits (bigint (/ num 10)) :accum (conj accum current-num))
      accum)))

(defn armstrong? [num]
  (let [numbers-list (num-to-digits num)
        powered-list (map #(.pow % (count numbers-list)) numbers-list)]
    (= (reduce + powered-list) num)))
