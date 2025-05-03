import React, { useState } from "react";
import {
  Card,
  CardContent,
  Typography,
  TextField,
  Button,
} from "@mui/material";
import { useAppContext } from "../context/AppContext.tsx";
import { postMessage, fetchTimeline } from "../services/service.ts";

export const PostMessageSection = () => {
  const [message, setMessage] = useState("");
  const { setTimeline } = useAppContext();

  const handlePostMessage = async () => {
    try {
      await postMessage(message);
      const data = await fetchTimeline();
      setTimeline(data);
    } catch (error) {
      console.error("Error posting message:", error);
      alert("Failed to post the message.");
    }
  };

  return (
    <Card
      style={{
        borderRadius: 0,
        border: "1px solid rgb(176, 213, 239)",
        height: "100%",
      }}
    >
      <CardContent>
        <Typography
          gutterBottom
          variant="h6"
          component="div"
          sx={{ fontWeight: "bold", color: "#1DA1F2" }}
        >
          Post a new message
        </Typography>
        <div style={{ display: "flex", flexDirection: "row", gap: 5 }}>
          <TextField
            fullWidth
            label="Your Post"
            variant="outlined"
            value={message}
            onChange={(e) => setMessage(e.target.value)}
          />
          <Button
            variant="contained"
            color="primary"
            size="small"
            onClick={handlePostMessage}
            sx={{
              textTransform: "none",
              fontWeight: "bold",
              backgroundColor: "primary.contrast",
              color: "primary.main",
              "&:hover": { backgroundColor: "#0d8ae0" },
            }}
          >
            Post
          </Button>
        </div>
      </CardContent>
    </Card>
  );
};
