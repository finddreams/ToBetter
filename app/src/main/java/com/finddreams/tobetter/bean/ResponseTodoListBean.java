package com.finddreams.tobetter.bean;

import java.util.List;

public class ResponseTodoListBean extends BaseResponseBean {
        /**
         * doneList : [{"date":1532793600000,"todoList":[{"completeDate":1533052800000,"completeDateStr":"2018-08-01","content":"这里可以记录笔记，备忘信息等。","date":1532793600000,"dateStr":"2018-07-29","id":82,"status":1,"title":"已经完成的事情","type":0,"userId":2}]}]
         * todoList : [{"date":1532016000000,"todoList":[{"completeDate":null,"completeDateStr":"","content":"","date":1532016000000,"dateStr":"2018-07-20","id":73,"status":0,"title":"第一件未完成的事情","type":0,"userId":2}]},{"date":1532448000000,"todoList":[{"completeDate":null,"completeDateStr":"","content":"","date":1532448000000,"dateStr":"2018-07-25","id":80,"status":0,"title":"第二件未完成的事情","type":0,"userId":2}]}]
         * type : 0
         */

        public int type;
        public List<DoneListBean> doneList;
        public List<TodoListBeanXX> todoList;

        public static class DoneListBean {
            /**
             * date : 1532793600000
             * todoList : [{"completeDate":1533052800000,"completeDateStr":"2018-08-01","content":"这里可以记录笔记，备忘信息等。","date":1532793600000,"dateStr":"2018-07-29","id":82,"status":1,"title":"已经完成的事情","type":0,"userId":2}]
             */

            public long date;
            public List<TodoListBean> todoList;

            public static class TodoListBean {
                /**
                 * completeDate : 1533052800000
                 * completeDateStr : 2018-08-01
                 * content : 这里可以记录笔记，备忘信息等。
                 * date : 1532793600000
                 * dateStr : 2018-07-29
                 * id : 82
                 * status : 1
                 * title : 已经完成的事情
                 * type : 0
                 * userId : 2
                 */

                public long completeDate;
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

        public static class TodoListBeanXX {
            /**
             * date : 1532016000000
             * todoList : [{"completeDate":null,"completeDateStr":"","content":"","date":1532016000000,"dateStr":"2018-07-20","id":73,"status":0,"title":"第一件未完成的事情","type":0,"userId":2}]
             */

            public long date;
            public List<TodoListBeanX> todoList;

            public static class TodoListBeanX {
                /**
                 * completeDate : null
                 * completeDateStr :
                 * content :
                 * date : 1532016000000
                 * dateStr : 2018-07-20
                 * id : 73
                 * status : 0
                 * title : 第一件未完成的事情
                 * type : 0
                 * userId : 2
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
