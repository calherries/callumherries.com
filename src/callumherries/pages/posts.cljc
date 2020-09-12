(ns callumherries.pages.posts
  (:require [markdown-to-hiccup.core :as m]
            [shadow.resource :as rc]))

;; for more about rc/inline, see
;; https://clojureverse.org/t/using-none-code-resources-in-cljs-builds/3745
(def posts-data
  [
   {:title    "Don't get bored"
    :date     "2017-02-17"
    :page-key :posts/dont-get-bored
    :url-name "dont-get-bored"
    :md       (rc/inline "./posts/2017-02-17-dont-get-bored.md")}
   {:title    "The hacker mentality, for life"
    :date     "2017-02-20"
    :page-key :posts/hacker-mentality
    :md       (rc/inline "./posts/2017-02-20-hacker-mentality.md")}
   {:title    "10 common fallacies programmers make"
    :date     "2017-02-21"
    :page-key :posts/common-fallacies
    :md       (rc/inline "./posts/2017-02-21-10-common-fallacies.md")}])

(def posts
  (->> posts-data
       (map #(assoc % :hiccup (->> % :md m/md->hiccup m/component (drop 2))))))
