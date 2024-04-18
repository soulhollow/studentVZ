class Message {
    id: number;
    header: string;
    content: string;
    timestamp: Date;
    userId: number;

    constructor(id: number, header: string, content: string, timestamp: Date, userId: number, user: string) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.timestamp = timestamp;
        this.userId = userId;
    }
}