(ns battle-asserts.issues.next-greater-element-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.properties :as prop :include-macros true]
            [clojure.test.check.clojure-test :as ct :include-macros true]
            [test-helper :as h]
            [battle-asserts.issues.next-greater-element :as issue]))

(ct/defspec test-solution
  20
  (prop/for-all [v (issue/arguments-generator)]
                (let [result (apply issue/solution v)]
                  (if (not (empty? result))
                    (= (last result)
                       -1)
                    true))))

(h/generate-tests issue/test-data issue/solution)