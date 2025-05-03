import React from "react";
import { Card, CardContent, Typography } from "@mui/material";
import { useAppContext } from "../context/AppContext.tsx";
import { fetchTimeline, fetchUserTimeline } from "../services/service.ts";
import { calculateTimeSince } from "../utils/timeUtils.ts";

export const TimelineSection = () => {
  const { timeline, setTimeline, selectedCard, setSelectedCard } =
    useAppContext();

  const handleCardClick = async (username: string) => {
    try {
      if (selectedCard === username) {
        setSelectedCard(null);
        const data = await fetchTimeline();
        setTimeline(data);
      } else {
        setSelectedCard(username);
        const data = await fetchUserTimeline(username);
        setTimeline(data);
      }
    } catch (error) {
      console.error("Error fetching timeline:", error);
    }
  };

  return (
    <Card
      sx={{
        borderRadius: 0,
        border: "1px solid rgb(176, 213, 239)",
        backgroundColor: "#ffffff",
        height: "100%",
        overflowY: "auto",
      }}
    >
      <CardContent>
        <Typography
          gutterBottom
          variant="h6"
          component="div"
          sx={{ fontWeight: "bold", color: "primary.contrast" }}
        >
          Timeline
        </Typography>
        {timeline.map((message) => (
          <Card
            key={message.id}
            sx={{
              marginBottom: "10px",
              border: "1px solid rgb(176, 213, 239)",
              borderRadius: 2,
              cursor: "pointer",
              boxShadow: 0,
              backgroundColor:
                selectedCard === message.username
                  ? "info.main"
                  : "primary.main",
              "&:hover": { backgroundColor: "info.main" },
            }}
            onClick={() => handleCardClick(message.username)}
          >
            <CardContent>
              <Typography
                sx={{
                  fontWeight: "bold",
                  color: "primary.contrast",
                  marginBottom: 1,
                }}
              >
                {message.username}
              </Typography>
              <Typography
                sx={{
                  fontSize: "0.85em",
                  color: "secondary.main",
                  marginBottom: 1,
                }}
              >
                {calculateTimeSince(message.createdAt)}
              </Typography>
              <Typography sx={{ color: "secondary.main", lineHeight: 1.5 }}>
                {message.content}
              </Typography>
            </CardContent>
          </Card>
        ))}
      </CardContent>
    </Card>
  );
};

export default TimelineSection;
