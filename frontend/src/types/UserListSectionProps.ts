import { User } from "./Models";

export interface UserListSectionProps {
  title: string;
  users: User[];
  buttonText: string;
  onButtonClick: (username: string) => void;
}
