import { User } from "./Models";

export interface AppContextType {
  followedUsers: User[];
  nonFollowedUsers: User[];
  timeline: any[];
  setTimeline: React.Dispatch<React.SetStateAction<any[]>>;
  fetchAllData: () => Promise<void>;
  selectedCard: string | null;
  setSelectedCard: React.Dispatch<React.SetStateAction<string | null>>;
}
