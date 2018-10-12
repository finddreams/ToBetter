package com.finddreams.tobetter.bean;

import java.util.List;

public class ResponseTodoListBean {

    /**
     * doneList : []
     * todoList : [{"date":1533571200000,"todoList":[{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2597,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2598,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2599,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2600,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2601,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2602,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2603,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2604,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2605,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2606,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2607,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2608,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2609,"status":0,"title":"todolist","type":0,"userId":10871}]},{"date":1535126400000,"todoList":[{"completeDate":null,"completeDateStr":"","content":"不拿","date":1535126400000,"dateStr":"2018-08-25","id":2632,"status":0,"title":"好的啊","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"不拿","date":1535126400000,"dateStr":"2018-08-25","id":2633,"status":0,"title":"好的","type":0,"userId":10871}]}]
     * type : 0
     */

    private int type;
    private List<TodoListBeanX> doneList;
    private List<TodoListBeanX> todoList;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<TodoListBeanX> getDoneList() {
        return doneList;
    }

    public void setDoneList(List<TodoListBeanX> doneList) {
        this.doneList = doneList;
    }

    public List<TodoListBeanX> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<TodoListBeanX> todoList) {
        this.todoList = todoList;
    }

    public static class TodoListBeanX {
        /**
         * date : 1533571200000
         * todoList : [{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2597,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2598,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2599,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2600,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2601,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2602,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2603,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2604,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2605,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2606,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2607,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2608,"status":0,"title":"todolist","type":0,"userId":10871},{"completeDate":null,"completeDateStr":"","content":"content","date":1533571200000,"dateStr":"2018-08-07","id":2609,"status":0,"title":"todolist","type":0,"userId":10871}]
         */

        private long date;
        private List<TodoListBean> todoList;

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public List<TodoListBean> getTodoList() {
            return todoList;
        }

        public void setTodoList(List<TodoListBean> todoList) {
            this.todoList = todoList;
        }

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

            private String completeDate;
            private String completeDateStr;
            private String content;
            private long date;
            private String dateStr;
            private int id;
            private int status;
            private String title;
            private int type;
            private int userId;
            public String level;
            public boolean isTitle;

            public String getCompleteDate() {
                return completeDate;
            }

            public void setCompleteDate(String completeDate) {
                this.completeDate = completeDate;
            }

            public String getCompleteDateStr() {
                return completeDateStr;
            }

            public void setCompleteDateStr(String completeDateStr) {
                this.completeDateStr = completeDateStr;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public long getDate() {
                return date;
            }

            public void setDate(long date) {
                this.date = date;
            }

            public String getDateStr() {
                return dateStr;
            }

            public void setDateStr(String dateStr) {
                this.dateStr = dateStr;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }
    }
}
