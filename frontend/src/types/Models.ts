export interface Message {
  id: string;
  content: string;
  username: string;
  createdAt: string;
}

export interface User {
  id: string;
  username: string;
  following: User[];
  followers: User[];
}
