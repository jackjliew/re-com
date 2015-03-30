(ns re-demo.layouts
  (:require [re-com.core   :refer [h-box v-box box gap line scroller border h-layout v-layout title flex-child-style]]
            [re-com.layout :refer [h-layout-args-desc v-layout-args-desc]]
            [re-demo.utils :refer [panel-title component-title args-table github-hyperlink status-text paragraphs]]))


(def rounded-panel (merge (flex-child-style "1")
                          {:background-color "#fff4f4"
                           :border           "1px solid lightgray"
                           :border-radius    "4px"
                           :padding          "0px 20px 0px 20px"}))

(defn layout-panel-title
  [text]
  [title
   :label text
   :level :level3
   :style {:margin-top "20px"}])

(defn left-panel
  []
  [box
   :size "auto"
   :child [:div {:style rounded-panel}
           [layout-panel-title [:code ":panel-1"]]]])


(defn right-panel
  []
  [box
   :size "auto"
   :child [:div {:style rounded-panel}
           [layout-panel-title [:code ":panel-2"]]]])


(defn top-panel
  []
  [box
   :size "auto"
   :child [:div {:style rounded-panel}
           [layout-panel-title [:code ":panel-1"]]]])


(defn bottom-panel
  []
  [box
   :size "auto"
   :child [:div {:style rounded-panel}
           [layout-panel-title [:code ":panel-2"]]]])


(defn panel
  []
  [v-box
   :size     "auto"
   :gap      "10px"
   :children [[panel-title [:span "Layout Components"
                            [github-hyperlink "Component Source" "src/re_com/layout.cljs"]
                            [github-hyperlink "Page Source"      "src/re_demo/layouts.cljs"]]]

              [h-box
               :gap      "100px"
               :children [[v-box
                           :gap      "10px"
                           :width    "450px"
                           :children [[component-title "[h-layout ...]"]
                                      [status-text "Stable"]
                                      [paragraphs
                                       [:p "Arranges two components horizontally and provides a splitter bar between them."]
                                       [:p "By dragging the splitter bar, a user can change the width allocated to each."]
                                       [:p "Can contain further nested layout components."]]
                                      [args-table h-layout-args-desc]]]
                          [v-box
                           :size     "auto"
                           :gap      "10px"
                           :children [[component-title "Demo"]
                                      [h-layout
                                       :panel-1 [left-panel]
                                       :panel-2 [right-panel]]]]]]
              [line :style {:margin-top "20px"}]
              [h-box
               :gap      "100px"
               :children [[v-box
                           :gap      "10px"
                           :width    "450px"
                           :children [[component-title "[v-layout ...]"]
                                      [paragraphs
                                       [:p "Same as above, but vertical."]]
                                      [args-table v-layout-args-desc]]]
                          [v-box
                           :size     "auto"
                           :gap      "10px"
                           :children [[component-title "Demo"]
                                      [v-layout
                                       :panel-1       [top-panel]
                                       :panel-2       [bottom-panel]
                                       :initial-split "25%"]]]]]
              [gap :size "30px"]]])
