package com.ws.demo.models;

public class Student {
    private String id;
    private String name;
    private int age;
    private String email;
    private String subject;

    public Student(String id, String name, int age, String email, String subject) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


}
