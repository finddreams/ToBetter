package com.finddreams.tobetter.bean;

import java.util.List;

public class ResponseTodoListBean extends BaseResponseResult {

    /**
     * data : {"doneList":[],"todoList":[{"date":1533571200000,"todoList":[{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2597,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2598,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2599,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2600,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2601,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2602,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2603,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2604,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2605,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2606,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2607,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2608,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2609,"status":0,"title":"todolist","type":0,"userId":10871}]},{"date":1535126400000,"todoList":[{"completeDate":null,"completeDateStr":"","content":"不拿","date":1535126400000,"dateStr":"2018-08-25","id":2632,"status":0,"title":"好的啊","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"不拿","date":1535126400000,"dateStr":"2018-08-25","id":2633,"status":0,"title":"好的","type":0,"userId":10871}]}],"type":0}
     */

    public DataBean data;

    public static class DataBean {
        /**
         * doneList : []
         * todoList : [{"date":1533571200000,"todoList":[{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2597,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2598,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2599,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2600,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2601,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2602,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2603,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2604,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2605,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2606,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2607,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2608,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2609,"status":0,"title":"todolist","type":0,"userId":10871}]},{"date":1535126400000,"todoList":[{"completeDate":null,"completeDateStr":"","content":"不拿","date":1535126400000,"dateStr":"2018-08-25","id":2632,"status":0,"title":"好的啊","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"不拿","date":1535126400000,"dateStr":"2018-08-25","id":2633,"status":0,"title":"好的","type":0,"userId":10871}]}]
         * type : 0
         */

        public int type;
        public List<TodoListBeanX> doneList;
        public List<TodoListBeanX> todoList;

        public static class TodoListBeanX {
            /**
             * date : 1533571200000
             * todoList : [{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2597,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2598,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2599,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2600,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2601,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2602,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2603,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2604,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2605,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2606,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2607,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2608,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2609,"status":0,"title":"todolist","type":0,"userId":10871}]
             */

            public long date;
            public List<TodoListBean> todoList;

            public static class TodoListBean {
                /**
                 * completeDate : null
                 * completeDateStr :
                 * content : content
                 * date : 1533571200000
                 * dateStr : 2018-08-07
                 * id : 2597
                 * status : 0
                 * title : todolist
                 * type : 0
                 * userId : 10871
                 */

                public String completeDate;
                public String completeDateStr;
                public String content;
                public long date;
                public String dateStr;
                public int id;
                public int status;
                public String title;
                public int type;
                public int userId;
            }
        }
    }
}
