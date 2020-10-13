(ns callumherries.pages.index
  (:require [callumherries.routes :as routes]
            [callumherries.pages.posts :as posts]
            [callumherries.components :as components]
            [bidi.bidi :as b]))


(defn hiccup []
  [:table.font-mono
   (for [{:keys [page-key title date]} posts/posts]
     [:tr.align-top
      [:td.whitespace-no-wrap.pr-3 date]
      [:td.break-normal [:a {:href (str "/posts/" (name page-key) ".html")} title]]])])
