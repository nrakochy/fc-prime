(ns fc-prime.core)

(defn is-not-multiple? 
  "Finds if number is not a multiple of given prime" 
  [param prime-num]
   (not= (mod param prime-num) 0))

(defn filter-multiples [reduced-coll]
  (filter #(is-not-multiple? % (first reduced-coll)) (rest reduced-coll)))

(defn greedy-filter-multiples [coll] (doall (filter-multiples coll)))

(defn terminate-prime-finder? [num-primes results coll]
  (or (= (count results) num-primes) (empty? coll)))

(defn prime-sieve 
  "Finds requested number of primes from a given collection. Terminates when number is found or range is empty"
  [num-primes range-max func]
    (loop [num-primes num-primes
           results [2]
           coll (range 3 range-max 2)]
      (if (terminate-prime-finder? num-primes results coll) 
        results
        (recur num-primes (conj results (first coll)) (func coll)))))

(defn prime-switch [num-primes range-max]
  (if (> range-max 100000) 
    (prime-sieve num-primes range-max greedy-filter-multiples))
    (prime-sieve num-primes range-max filter-multiples))

(defn find-primes 
  "Finds desired number primes between 2 and a given max. Defaults to return 10 primes less than 1000"
  ([] (find-primes 1000))
  ([range-max] (find-primes range-max 10))
  ([range-max num-primes] (prime-switch num-primes range-max)))
