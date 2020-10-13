(ns callumherries.components
  (:require [callumherries.routes :as routes]
            [bidi.bidi :as b]))

(def header
  [:div.float-left.mr-10.mb-5 {:id    "menu"
                               :style {:min-width "11rem"}}
   [:ul.font-bold.text-2xl.font-mono
    [:li [:h1 "Callum Herries"]]
    [:li [:a.no-underline.hover:underline {:href (b/path-for routes/routes :page/index)} "Blog"]]
    [:li [:a.no-underline.hover:underline {:href (b/path-for routes/routes :page/about)} "About"]]]])

(defn page [contents]
  [[:div.m-5
    header
    [:div.vbox.float-left
     {:style {:width "100%"
              :max-width "620px"}}
     contents]]])
